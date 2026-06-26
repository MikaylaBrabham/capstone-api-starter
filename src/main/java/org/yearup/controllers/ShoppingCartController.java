package org.yearup.controllers;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.models.Category;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.User;
import org.yearup.service.ShoppingCartService;
import org.yearup.service.UserService;

import java.security.Principal;

// convert this class to a REST controller
@RestController
@RequestMapping("/cart")
@CrossOrigin
@PreAuthorize("isAuthenticated()")


// only logged in users should have access to these actions
public class ShoppingCartController {  // a shopping cart controller depends on the service layer
    // <ShoppingCart> addProductToCart(@PathVariable int productId, Principal principal) {
    private ShoppingCartService shoppingCartService;
    private UserService userService;

    //add autowired to ensure users only
    @Autowired
    //add constructors
    public ShoppingCartController(ShoppingCartService shoppingCartService, UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }


    // each method in this controller requires a Principal object as a parameter
    // @PreAuthorize(("isAuthenticated()"))
    @GetMapping
    public ShoppingCart getCart(Principal principal) {
        // get the currently logged in username
        String userName = principal.getName();
        // find database user by username
        User user = userService.getByUserName(userName);
        int userId = user.getId();

        // use the shoppingCartService to get all items in the cart and return the cart
        return shoppingCartService.getByUserId(userId);
    }

    // add a POST method to add a product to the cart - the url should be
    @PostMapping("/products/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    // https://localhost:8080/cart/products/15  (15 is the productId to be added)
    // return the updated cart with status 201 Created
    public ShoppingCart addProduct(@PathVariable int productId, Principal principal) {
        // get the currently logged in username
        String userName = principal.getName();
        // find database user by username
        User user = userService.getByUserName(userName);
        int userId = user.getId();

        // use the shoppingCartService to get all items in the cart and return the car
        return shoppingCartService.addProduct(userId, productId);
    }
}

        // Product newProduct =new Product();
        // return ShoppingCartService.
//}


        // add a PUT method to update an existing product in the cart - the url should be
        //@PutMapping("/products/{productId}")
        // https://localhost:8080/cart/products/15  (15 is the productId to be updated)
        // the BODY should be a ShoppingCartItem - quantity is the only value that will be updated; return the cart (200 OK)


        // add a DELETE method to clear all products from the current users cart
        // @DeleteMapping
        // https://localhost:8080/cart  - return the (now empty) cart so the front end can refresh it (200 OK)

