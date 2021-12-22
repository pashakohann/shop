package com.epam.shop.controller;


import com.epam.shop.controller.command.api.Command;

import com.epam.shop.controller.context.api.ResponseContext;
import com.epam.shop.controller.context.impl.RequestContextImpl;


import com.epam.shop.service.exception.ServiceException;

import com.epam.shop.service.impl.ConnectionServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.io.IOException;


@WebServlet(urlPatterns = "/shop")
public class ApplicationController extends HttpServlet {
    private static final String COMMAND_PARAMETER_NAME = "command";
    private static final String NAME = "name";
    private static final Logger log = LogManager.getLogger(ApplicationController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (ServiceException e) {
            log.error(" mistake of the servlet", e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            process(req, resp);
        } catch (ServiceException e) {
            log.error(" mistake of the servlet", e);
        }
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ServiceException {

        final String commandName = req.getParameter(COMMAND_PARAMETER_NAME);

        final Command command = Command.withName(commandName);

        final ResponseContext response = command.execute(new RequestContextImpl(req));

        if (response.isRedirect()) {
            resp.sendRedirect(response.getPath());
        } else {
            final RequestDispatcher dispatcher = req.getRequestDispatcher(response.getPath());
            dispatcher.forward(req, resp);
        }

    }


    @Override
    public void destroy() {

        try {
            ConnectionServiceImpl.getInstance().destroy();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            ConnectionServiceImpl.getInstance().init();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }



}
