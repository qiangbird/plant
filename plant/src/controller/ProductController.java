package controller;

import java.util.List;

import model.Product;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ProductService;
import VO.ProductVo;

@Controller("productcontroller")
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    public void saveProduct(ProductVo productVo){
        
        productService.saveProduct(productVo);
    }
    
    public void updateProduct(ProductVo productVo){
        
        productService.updateProduct(productVo);
    }
    
    @ResponseBody
    public JSONObject getProduct(ProductVo productVo){
        
        JSONObject product = productService.getProduct(productVo);
        
        return product;
    }
    
    public List<Product> findAllKindsProducts(){
        
        List<Product> products = productService.findAllKindsProducts();
        
        return products;
    }
    
    public List<Product> findProductsByType(ProductVo productVo){
        
        List<Product> products = productService.findProductsByType(productVo);
        
        return products;
    }
    
    public void deleteProduct(ProductVo productVo){
        
        productService.deleteProduct(productVo);
    }
}
