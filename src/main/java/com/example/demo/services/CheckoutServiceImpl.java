package com.example.demo.services;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {


    @Autowired
    private CartRepository cartRepository;


    @Autowired
    private CartItemRepository cartItemRepository;


    //private CustomerRepository customerRepository;


    public CheckoutServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        //this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {


        //retrieve the cart info
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();


        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);


        //populate cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cartItem -> {
            cart.add(cartItem);
            cartItem.setCart(cart);
        });
        //save to database
        cartRepository.save(cart);
        //cartItemRepository.save(cartItem);


        //populate customers




        //populate customer with order
        cart.setStatus(StatusType.ordered);




        //save to database
        //customerRepository.save(customer);




        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }


    private String generateOrderTrackingNumber() {


        //generate a random UUID number
        return UUID.randomUUID().toString();
    }
}
