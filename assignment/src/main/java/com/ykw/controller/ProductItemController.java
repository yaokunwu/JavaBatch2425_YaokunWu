package com.ykw.controller;

import com.ykw.entity.ProductItem;
import com.ykw.exception.ProductItemNotFoundException;
import com.ykw.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductItemController {

    @Autowired
    ProductItemService productItemService;

    //create
    @RequestMapping(value = "/productitem", method = RequestMethod.POST, consumes = "application/json")
    public String createProductItem(@RequestBody ProductItem productItem) {
        productItemService.saveProductItem(productItem);
        return "Send successfully";
    }

    //update
    @RequestMapping(value = "/productitem/{id}", method = RequestMethod.PUT)
    public String updateProductItem(@PathVariable("id") long id, @RequestBody ProductItem productItem){
        ProductItem currentProductItem = productItemService.findById(id);
        if (currentProductItem == null) {
            throw new ProductItemNotFoundException("ProductItem_NOT_FOUND");
        }
        currentProductItem.setName(productItem.getName());
        currentProductItem.setPrice(productItem.getPrice());
        productItemService.updateProductItem(currentProductItem);
        return "Update successfully";
    }

    //delete
    @RequestMapping(value = "/productitem/{id}", method = RequestMethod.DELETE)
    public String deleteProductItem(@PathVariable("id") long id) {
        ProductItem productItem = productItemService.findById(id);
        if (productItem == null) {
            throw new ProductItemNotFoundException("ProductItem_NOT_FOUND");
        }
        productItemService.deleteProductItemById(id);
        return "Delete successfully";
    }

    //get single item
    @RequestMapping(value = "/productitem/{uid}", method = RequestMethod.GET)
    public String getProductItem(@PathVariable("uid") long id) throws ProductItemNotFoundException {
        ProductItem productItem = productItemService.findById(id);
        if (productItem == null) {
            throw new ProductItemNotFoundException("ProductItem_NOT_FOUND");
        }
        return productItem.toString();
    }

    //get all items
    @RequestMapping(value = "/productitem", method = RequestMethod.GET)
    public String getAllProductItem() throws ProductItemNotFoundException {
        List<ProductItem> productItems = productItemService.findAllProductItems();
        return productItems.toString();
    }

    //local exception handler
    @ExceptionHandler(ProductItemNotFoundException.class)
    public String exceptionHandlerUserNotFound(Exception ex) {
        return "ProductItem_NOT_FOUND Handled Locally";
    }
}
