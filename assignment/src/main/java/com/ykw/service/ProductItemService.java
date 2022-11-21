package com.ykw.service;

import com.ykw.entity.ProductItem;

import java.util.List;

public interface ProductItemService {

    ProductItem findById(long id);

    ProductItem saveProductItem(ProductItem ProductItem);

    ProductItem updateProductItem(ProductItem ProductItem);

    void deleteProductItemById(long id);

    List<ProductItem> findAllProductItems();

}
