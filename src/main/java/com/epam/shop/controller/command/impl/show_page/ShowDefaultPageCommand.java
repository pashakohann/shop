package com.epam.shop.controller.command.impl.show_page;


import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.context.api.RequestContext;
import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.dto.model.UserDto;
import com.epam.shop.service.dto.model.UserRoleDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.factory.FactoryService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowDefaultPageCommand implements Command {
    public static Command command;
    private static final String MAIN_PAGE_PATH = "/jsp/main.jsp";
    private static final String ALL_PRODUCTS_LIST = "productsList";
    private static final String CURRENT_USER_ATTRIBUTE = "currentUser";


    private ShowDefaultPageCommand() {
    }

    public static Command getInstance() {
        if (command == null) {
            command = new ShowDefaultPageCommand();
        }
        return command;
    }

    private static final ResponseContext SHOW_MAIN_PAGE = new ResponseContext() {
        @Override
        public String getPath() {
            return MAIN_PAGE_PATH;
        }

        @Override
        public boolean isRedirect() {
            return false;
        }
    };


    @Override
    public ResponseContext execute(RequestContext requestContext) throws ServiceException {
        UserDto userDto = new UserDto();
        userDto.setRole(UserRoleDto.UNAUTHORIZED);
       List<ProductDto> productDtoList = FactoryService.getProductServiceInstance().getAll();

        HttpSession session = requestContext.getCurrentSession().get();
        session.setAttribute(ALL_PRODUCTS_LIST,productDtoList);
        session.setAttribute(CURRENT_USER_ATTRIBUTE,userDto);

        return SHOW_MAIN_PAGE;
    }
}
