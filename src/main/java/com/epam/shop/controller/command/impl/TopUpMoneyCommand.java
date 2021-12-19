package com.epam.shop.controller.command.impl;

import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TopUpMoneyCommand implements Command {
    public static Command command;
    private static final String BACK_TO_WALLET_PATH = "/jsp/your_wallet.jsp";

    private static final String ACCOUNT_AMOUNT_ATTRIBUTE = "amount";
    private static final String ACCOUNT_OBJECT_ATTRIBUTE = "account";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "message";
    private static final String ERROR_ATTRIBUTE = "error";


    private TopUpMoneyCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new TopUpMoneyCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_WALLET_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return BACK_TO_WALLET_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }

    };


    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        HttpSession httpSession = requestContext.getCurrentSession().get();

        try {

            BigDecimal bigDecimal = new BigDecimal(requestContext.getParameter(ACCOUNT_AMOUNT_ATTRIBUTE));
            AccountDto accountDto = (AccountDto) httpSession.getAttribute(ACCOUNT_OBJECT_ATTRIBUTE);
            accountDto.setAmount(accountDto.getAmount().add(bigDecimal));
            accountDto = FactoryService.getAccountServiceInstance().update(accountDto);
            httpSession.setAttribute(ACCOUNT_OBJECT_ATTRIBUTE, accountDto);
        } catch (ServiceException e) {
            //log
            requestContext.setAttribute(ERROR_ATTRIBUTE, MESSAGE_ERROR_ATTRIBUTE + ": " + e.getMessage());
        }

        return SHOW_WALLET_PAGE;
    }
}