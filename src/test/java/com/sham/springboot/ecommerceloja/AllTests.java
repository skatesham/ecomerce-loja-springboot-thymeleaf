package com.sham.springboot.ecommerceloja;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sham.springboot.ecommerceloja.domain.product.ProductServiceTest;
import com.sham.springboot.ecommerceloja.interfaces.controllers.ProductsControllerTest;

@RunWith(Suite.class)
@SuiteClasses({
	
	ProductServiceTest.class,
	ProductsControllerTest.class

})
public class AllTests {

}
