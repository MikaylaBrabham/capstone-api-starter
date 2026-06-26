package org.yearup.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.yearup.models.*;
import org.yearup.repository.ShoppingCartRepository;

import java.security.Principal;
import java.util.List;

@Service
public class ShoppingCartService {
    // a shopping cart is built from cart rows plus a product lookup for each row
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductService productService;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productService = productService;
    }

    //for get mapping
    public ShoppingCart getByUserId(int userId) {
        // load the user's cart rows, look up each product, and build the ShoppingCart
        List<CartItem> cartItems = shoppingCartRepository.findByUserId(userId);

        //create empty cart
        ShoppingCart cart = new ShoppingCart();

        //create a for loop to go through the cart rows
        for (CartItem cartItem : cartItems) {
            //get product ID to each product
            Product product = productService.getById(cartItem.getProductId());

            //create the shopping cart item
            ShoppingCartItem shoppingCartItem = new ShoppingCartItem();

            //set the product user purchasing
            shoppingCartItem.setProduct(product);
            //set the quantity user purchasing
            shoppingCartItem.setQuantity(cartItem.getQuantity());

            //add the items to the shopping cart
            cart.add(shoppingCartItem);
        }
        // return the completed shopping cart
        return cart;
    }


// only logged in users should have access to these actions

    // add a POST method to add a product to the cart - the url should be
    // https://localhost:8080/cart/products/15  (15 is the productId to be added)
    // return the updated cart with status 201 Created
    public ShoppingCart addProduct(int userId, int productId) {
        //see if user already has product in their cart
        CartItem item = shoppingCartRepository.findByUserIdAndProductId(userId, productId);

        // if they do have one increase the quantitty in the cart
        if (item != null) {
            // increase the quantity plus 1 if they do have it
            item.setQuantity(item.getQuantity() + 1);
            // save it in cart
            shoppingCartRepository.save(item);
        } else {
            //if they don't have it, make a new row of product details
            CartItem newItem = new CartItem();
            newItem.setUserId(userId);
            newItem.setProductId(productId);
            newItem.setQuantity(1);
            shoppingCartRepository.save(newItem);
        }
        //return their updated cart with their product
        return getByUserId(userId);
    }


    // add a PUT method to update an existing product in the cart - the url should be
    //@PutMapping("/products/{productId}")
    // https://localhost:8080/cart/products/15  (15 is the productId to be updated)
    // the BODY should be a ShoppingCartItem - quantity is the only value that will be updated; return the cart (200 OK)
    public ShoppingCart updateItemQuantity(int userId, int productId, ShoppingCartItem item){
        CartItem cartItem = shoppingCartRepository.findByUserIdAndProductId(userId, productId);

        if (cartItem != null) {
            cartItem.setQuantity((cartItem.getQuantity()));
            shoppingCartRepository.save(cartItem);
        }
        return  getByUserId(userId);
    }

    // add a DELETE method to clear all products from the current users cart
    // @DeleteMapping
    // https://localhost:8080/cart  - return the (now empty) cart so the front end can refresh it (200 OK)

    public ShoppingCart clearCart(int userId) {
        shoppingCartRepository.deleteByUserId(userId);
        return getByUserId(userId);
    }

    }


