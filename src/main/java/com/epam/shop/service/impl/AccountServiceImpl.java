package com.epam.shop.service.impl;

import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.factory.FactoryDao;
import com.epam.shop.dao.model.Account;
import com.epam.shop.service.api.AccountService;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.converter.impl.AccountConverterImpl;
import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceAccountExceptionString;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.impl.AccountValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private static AccountService instance;
    private final Validator<AccountDto, Integer> validatorInstance = AccountValidatorImpl.getInstance();
    private static final Logger logger = LogManager.getLogger(AccountServiceImpl.class);
    private final Converter<AccountDto, Account, Integer> converter = AccountConverterImpl.getConverterInstance();

    private AccountServiceImpl() {
    }

    public static AccountService getInstance() {
        if (instance == null) {
            instance = new AccountServiceImpl();
        }
        return instance;
    }

    @Override
    public AccountDto create(AccountDto account) throws ServiceException {
        try {
            account.setDateOfBirth(LocalDate.now());
            account.setStreet("default");
            account.setFirstName("default");
            account.setLastName("default");
            account.setFlat(0);
            account.setEmail("default");
            account.setTelephoneNumber("default");
            account.setCity("default");
            account.setAmount(BigDecimal.ZERO);
            account = converter.convert(FactoryDao.getAccountImpl().save(converter.convert(account)));
        } catch (DaoException e) {
            logger.error(ServiceAccountExceptionString.CREATE_ACCOUNT_FOR_USER, e);
            throw new ServiceException(ServiceAccountExceptionString.CREATE_ACCOUNT_FOR_USER, e);

        }

        return account;
    }

    @Override
    public AccountDto update(AccountDto accountDto) throws ServiceException {

        try {
            FactoryDao.getAccountImpl().update(converter.convert(accountDto));
        } catch (DaoException e) {
            logger.error(ServiceAccountExceptionString.UPDATE_ACCOUNT, e);
            throw new ServiceException(ServiceAccountExceptionString.UPDATE_ACCOUNT, e);
        }

        return accountDto;
    }

    @Override
    public void delete(AccountDto model) throws ServiceException {
        try {
            FactoryDao.getAccountImpl().delete(model.getId());
        } catch (DaoException e) {
            logger.error(ServiceAccountExceptionString.DELETE_ACCOUNT, e);
            throw new ServiceException(ServiceAccountExceptionString.DELETE_ACCOUNT, e);
        }
    }

    @Override
    public AccountDto getById(Integer id) throws ServiceException {
        AccountDto accountDto;
        try {
            accountDto = converter.convert(FactoryDao.getAccountImpl().findById(id));
        } catch (DaoException e) {
            logger.error(ServiceAccountExceptionString.FIND_BY_ID_ACCOUNT, e);
            throw new ServiceException(ServiceAccountExceptionString.FIND_BY_ID_ACCOUNT, e);
        }
        return accountDto;
    }

    public AccountDto findByUserId(int userId) throws ServiceException {
        AccountDto accountDto;
        try {
            accountDto = converter.convert(FactoryDao.getAccountImpl().findByUserId(userId));
        } catch (DaoException e) {
            logger.error(ServiceAccountExceptionString.FIND_BY_USER_ID_ACCOUNT, e);
            throw new ServiceException(ServiceAccountExceptionString.FIND_BY_USER_ID_ACCOUNT, e);
        }
        return accountDto;
    }

    @Override
    public List<AccountDto> getAll() throws ServiceException {
        List<AccountDto> listAccountDto;
        List<Account> listAccount;
        try {
            listAccount = FactoryDao.getAccountImpl().findAll();
            listAccountDto = new ArrayList<>();
            for (Account account : listAccount) {
                listAccountDto.add(converter.convert(account));
            }
        } catch (DaoException e) {
            logger.error(ServiceAccountExceptionString.FIND_ALL_ACCOUNTS, e);
            throw new ServiceException(ServiceAccountExceptionString.FIND_ALL_ACCOUNTS, e);
        }

        return listAccountDto;
    }
}
