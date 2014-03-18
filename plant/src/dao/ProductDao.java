package dao;

import java.util.List;

import model.Product;

public interface ProductDao extends BaseDao<Product>{

    /**
     * Find products by type
     * @param type
     * @return
     */
    List<Product> findProductsByType(String type);

}
