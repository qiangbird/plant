package dao;

import java.util.List;

import model.BaseModel;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

import VO.Page;

public interface BaseDao<T extends BaseModel> {

    /**
     * Save a model
     * @param model
     * @return
     */
    T save(T model);
    
    /**
     * Delete a mode
     * @param model
     */
    void delete(T model);
    
    /**
     * Update a model
     * @param model
     * @return
     */
    T update(T model);
    
    /**
     * Get a mode by model id
     * @param modelClass
     * @param id
     * @return
     */
    T get(Class<T> modelClass, String id);
    
    /**
     * Find the records which satisfy the conditions
     * @param hql
     * @param values
     * @return
     */
    List<T> find(String hql, Object... values);
    
    /**
     * Find all the records of the model class
     * @param modelClass
     * @return
     */
    List<T> findAll(Class<T> modelClass);
    
    /**
     * Execute a query based on a given Hibernate criteria object
     * @param criteria
     * @return
     */
    List<T> findByCriteria(DetachedCriteria criteria);
    
    /**
     * Execute a query based on a given Hibernate criteria object,
     * this is used for pagination
     * @param criteria
     * @param page
     * @return
     */
    Page<T> findByCriteria(DetachedCriteria criteria, Page<T> page);
    
    /**
     * This is used for pagination which needs the hql and  and 
     * other conditions
     * @param page
     * @param hql
     * @param values
     * @return
     */
    Page<T> findByHql(final Page<T> page, final String hql,
            final Object... values);
    
    /**
     * Get the total count of the model records
     * @param modelClass
     * @return
     */
    int getTotalCount(Class<T> modelClass);
    
    /**
     * Get the total count of the model records by criteria
     * @param criteria
     * @return
     */
    int getCountByCriteria(DetachedCriteria criteria);
    
    /**
     * Get the total count of the model records by hql
     * @param hql
     * @param values
     * @return
     */
    int getCountByHql(String hql, final Object... values);
    
    HibernateTemplate getHibernateTemplate();
    
    /**]
     * Bulk save or update the model
     * @param entities
     * @return
     */
    List<T> saveOrUpdateAll(List<T> entities);
    
    
}
