package com.droolsrulesengine.droolsrulesengine;

import com.droolsrulesengine.droolsrulesengine.model.OrderDiscount;
import com.droolsrulesengine.droolsrulesengine.model.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
public class OrderController {

    @Autowired
    OrderDiscountService orderDiscountService;


    @PostMapping("/getDiscount")
    public ResponseEntity<OrderDiscount> getDiscount(@RequestBody OrderRequest request) {
        OrderDiscount orderDiscount = orderDiscountService.getDiscount(request);
        return  new ResponseEntity<OrderDiscount>(orderDiscount , HttpStatus.OK);
    }
}
