package com.ykw.service;

import com.ykw.dao.ProductItemRepository;
import com.ykw.entity.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service("ProductItemService")
public class ProductItemServiceImpl implements ProductItemService {

    @Autowired
    private ProductItemRepository productItemRepo;

    public List<ProductItem> findAllProductItems() {
        List<ProductItem> productItems = productItemRepo.findAll();
        return productItems;
    }

    public ProductItem findById(long id) {
        ProductItem productItem = productItemRepo.findById(id).orElse(null);
        return productItem;
    }

    @Transactional
    public ProductItem saveProductItem(ProductItem productItem) {
        ProductItem savedproductItem = productItemRepo.save(new ProductItem(productItem.getId(), productItem.getName(), productItem.getPrice()));
        return savedproductItem;
    }

    public ProductItem updateProductItem(ProductItem productItem) {
        ProductItem savedproductItem = productItemRepo.saveAndFlush(new ProductItem(productItem.getId(), productItem.getName(), productItem.getPrice()));
        return savedproductItem;
    }

    public void deleteProductItemById(long id) {
        productItemRepo.deleteById(id);
    }
}

