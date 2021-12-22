package com.epam.shop.service.api;


import com.epam.shop.service.dto.model.AbstractModelDto;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.impl.BasketServiceImpl;


import java.util.List;
import java.util.Map;

public interface BasketService<T extends AbstractModelDto,K extends BasketServiceImpl> {
      Map<T,Integer> addProduct(ProductDto product)throws ServiceException;
      K deleteProduct(int productId)throws ServiceException;
      Map<T,Integer>lookBasket()throws ServiceException;
      K clearBasket()throws ServiceException;
      int basketSize() throws ServiceException;
      List<ProductDto> backToListProducts() throws ServiceException;

}
