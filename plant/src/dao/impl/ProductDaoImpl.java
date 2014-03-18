package dao.impl;

import java.util.List;

import model.Product;

import org.springframework.stereotype.Repository;

import dao.ProductDao;

@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{

    @Override
    public List<Product> findProductsByType(String type) {
        
        String hql = "FROM Product WHREE type = ? AND is_expired = ?";
        
        List<Product> products = find(hql, type, Boolean.FALSE);
        
        return products;
    }

}
