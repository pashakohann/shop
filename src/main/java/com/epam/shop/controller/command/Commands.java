package com.epam.shop.controller.command;


import com.epam.shop.controller.command.api.Command;
import com.epam.shop.controller.command.impl.AddProductInBasketCommand;
import com.epam.shop.controller.command.impl.AuthorizationCommand;
import com.epam.shop.controller.command.impl.ClearBasketCommand;
import com.epam.shop.controller.command.impl.DeleteProductFromBasketCommand;
import com.epam.shop.controller.command.impl.LanguageCommand;
import com.epam.shop.controller.command.impl.LookBasketCommand;
import com.epam.shop.controller.command.impl.OrderProductCommand;
import com.epam.shop.controller.command.impl.ReturnBackActionCommand;
import com.epam.shop.controller.command.impl.SignOutCommand;
import com.epam.shop.controller.command.impl.show_page.ShowDefaultPageCommand;
import com.epam.shop.controller.command.impl.FindProductsByCategoryBrandCommand;
import com.epam.shop.controller.command.impl.FindProductsByCategoryCommand;
import com.epam.shop.controller.command.impl.RegistrationCommand;
import com.epam.shop.controller.command.impl.show_page.ShowErrorPageCommand;
import com.epam.shop.controller.command.impl.show_page.ShowPageAccountCommand;
import com.epam.shop.controller.command.impl.show_page.ShowPageOrderCommand;
import com.epam.shop.controller.command.impl.show_page.ShowPanelCommand;
import com.epam.shop.controller.command.impl.show_page.ShowSignInPageCommand;
import com.epam.shop.controller.command.impl.show_page.ShowSignUpPageCommand;
import com.epam.shop.service.dto.model.UserRoleDto;

import java.util.Arrays;
import java.util.List;

public enum Commands {
    DEFAULT(ShowDefaultPageCommand.getInstance(), UserRoleDto.UNAUTHORIZED,UserRoleDto.USER, UserRoleDto.ADMIN),
    FIND_PRODUCTS_CATEGORY_BRAND(FindProductsByCategoryBrandCommand.getInstance(), UserRoleDto.USER, UserRoleDto.ADMIN, UserRoleDto.UNAUTHORIZED),
    FIND_PRODUCTS_CATEGORY(FindProductsByCategoryCommand.getInstance(), UserRoleDto.USER, UserRoleDto.ADMIN, UserRoleDto.UNAUTHORIZED),
    SHOW_SIGN_UP_PAGE(ShowSignUpPageCommand.getInstance(), UserRoleDto.USER, UserRoleDto.ADMIN, UserRoleDto.UNAUTHORIZED),
    SHOW_SIGN_IN_PAGE(ShowSignInPageCommand.getInstance(), UserRoleDto.USER, UserRoleDto.ADMIN, UserRoleDto.UNAUTHORIZED),
    REGISTRATION(RegistrationCommand.getInstance(), UserRoleDto.USER, UserRoleDto.ADMIN, UserRoleDto.UNAUTHORIZED),
    LANGUAGE_COMMAND(LanguageCommand.getInstance(), UserRoleDto.USER, UserRoleDto.ADMIN, UserRoleDto.UNAUTHORIZED),
    AUTHORIZATION_COMMAND(AuthorizationCommand.getInstance(), UserRoleDto.USER, UserRoleDto.ADMIN, UserRoleDto.UNAUTHORIZED),
    SIGN_OUT_COMMAND(SignOutCommand.getInstance(), UserRoleDto.USER, UserRoleDto.ADMIN),
    ADD_PRODUCT_COMMAND(AddProductInBasketCommand.getInstance(), UserRoleDto.USER, UserRoleDto.ADMIN),
    DELETE_PRODUCT_COMMAND(DeleteProductFromBasketCommand.getInstance(),UserRoleDto.USER, UserRoleDto.ADMIN),
    SHOW_BASKET_COMMAND(LookBasketCommand.getInstance(), UserRoleDto.USER, UserRoleDto.ADMIN),
    BACK_ACTION_COMMAND(ReturnBackActionCommand.getInstance(), UserRoleDto.USER, UserRoleDto.ADMIN),
    SHOW_ERROR_COMMAND(ShowErrorPageCommand.getInstance(),UserRoleDto.USER, UserRoleDto.ADMIN),
    CLEAR_BASKET_COMMAND(ClearBasketCommand.getInstance(), UserRoleDto.USER, UserRoleDto.ADMIN),
    ORDER_PRODUCTS_COMMAND(OrderProductCommand.getInstance(),UserRoleDto.USER, UserRoleDto.ADMIN),
    SHOW_PANEL_COMMAND(ShowPanelCommand.getInstance(),UserRoleDto.USER, UserRoleDto.ADMIN),
    SHOW_ACCOUNTS_COMMAND(ShowPageAccountCommand.getInstance(),UserRoleDto.ADMIN),
    SHOW_ORDERS_COMMAND(ShowPageOrderCommand.getInstance(),UserRoleDto.ADMIN);

//    DELETE_PRODUCT_COMMAND(),

//    CLEAR_BASKET_COMMAND();
//    SHOW_USERS(),
//    SHOW_ACCOUNTS(),
//    SHOW_PRODUCTS(),
//    REGISTRATION(),
//    SIGN_IN(),
//    SIGN_OUT(),
//    ORDER_PRDUCTS();

    private final Command command;
    private final List<UserRoleDto> allowedRoles;

    Commands(Command command, UserRoleDto... roles) {
        this.command = command;
        this.allowedRoles = roles != null && roles.length > 0 ? Arrays.asList(roles) : UserRoleDto.valuesAsList();
    }

    public Command getCommand() {
        return command;
    }

    public List<UserRoleDto> getAllowedRoles() {
        return allowedRoles;
    }

    public static Commands of(String name) {
        for (Commands command : values()) {
            if (command.name().equalsIgnoreCase(name)) {
                return command;
            }
        }
        return DEFAULT;
    }

}




