package service.impl;

import java.util.List;

import model.Product;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import service.ProductService;
import VO.ProductVo;
import dao.ProductDao;

@Repository("productService")
public class ProductServiceImpl implements ProductService{

    private Logger logger = Logger.getLogger(ProductServiceImpl.class);
    
    @Autowired
    private ProductDao productDao;

    /* (non-Javadoc)
     * @see service.ProductService#saveProduct(VO.ProductVo)
     */
    @Override
    public void saveProduct(ProductVo productVo) {
        
        logger.info("start...");
        
        Product product = new Product();
        
        product.setName(productVo.getName());
        product.setDescription(productVo.getDescription());
        product.setImgURL(productVo.getImgURL());
        
        productDao.save(product);
        
        logger.info("end...");
    }

    /* (non-Javadoc)
     * @see service.ProductService#updateProduct(VO.ProductVo)
     */
    @Override
    public void updateProduct(ProductVo productVo) {
        
        logger.info("start...");
        
        Product product = productDao.get(Product.class, productVo.getId());
        
        product.setName(productVo.getName());
        product.setDescription(productVo.getDescription());
        product.setImgURL(productVo.getImgURL());
        
        productDao.update(product);
        
        logger.info("end...");
    }

    /* (non-Javadoc)
     * @see service.ProductService#getProduct(VO.ProductVo)
     */
    @Override
    public JSONObject getProduct(ProductVo productVo) {
        
        logger.info("start...");
        
        Product product = productDao.get(Product.class, productVo.getId());
        
        JSONObject object = new JSONObject();
        
        object.put("productId", product.getId());
        object.put("name", product.getName());
        object.put("description", product.getDescription());
        object.put("imgURL", product.getImgURL());

        logger.info("end...");
        
        return object;
    }

    /* (non-Javadoc)
     * @see service.ProductService#findAllKindsProducts()
     */
    @Override
    public List<Product> findAllKindsProducts() {
        
        logger.info("start...");
        
        List<Product> products = productDao.findAll(Product.class);
        
        logger.info("end...");
        
        return products;
    }

    /* (non-Javadoc)
     * @see service.ProductService#findProductsByType(VO.ProductVo)
     */
    @Override
    public List<Product> findProductsByType(ProductVo productVo) {
        
        logger.info("start...");
        
        List<Product> products = productDao.findProductsByType(productVo.getType());
        
        logger.info("end...");
        
        return products;
    }

    /* (non-Javadoc)
     * @see service.ProductService#deleteProduct(VO.ProductVo)
     */
    @Override
    public void deleteProduct(ProductVo productVo) {
        
        Product product = productDao.get(Product.class, productVo.getId());
        productDao.delete(product);
    }
}
