package com.droolsrulesengine.droolsrulesengine;

import com.droolsrulesengine.droolsrulesengine.model.OrderDiscount;
import com.droolsrulesengine.droolsrulesengine.model.OrderRequest;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderDiscountService {

    @Autowired
    KieContainer kieContainer;

    public OrderDiscount getDiscount(OrderRequest orderRequest){
        OrderDiscount orderDiscount = new OrderDiscount();
        KieSession kieSession =  kieContainer.newKieSession();
        kieSession.setGlobal("orderDiscount" , orderDiscount);
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return orderDiscount;

    }

}

