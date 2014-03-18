package dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.BaseModel;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import VO.Page;
import dao.BaseDao;

@Repository("baseDao")
public class BaseDaoImpl<T extends BaseModel> implements BaseDao<T>{

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /* (non-Javadoc)
     * @see dao.BaseDao#save(model.BaseModel)
     */
    @Override
    public T save(T model) {
        
        Date date = new Date();
        
        model.setCreatedTime(date);
        model.setUpdatedTime(date);
        
        hibernateTemplate.save(model);
        
        return model;
    }

    /* (non-Javadoc)
     * @see dao.BaseDao#delete(model.BaseModel)
     */
    @Override
    public void delete(T model) {
        
        Date date = new Date();
        
        model.setExpired(Boolean.TRUE);
        model.setUpdatedTime(date);
        
        hibernateTemplate.delete(model);
    }

    /* (non-Javadoc)
     * @see dao.BaseDao#update(model.BaseModel)
     */
    @Override
    public T update(T model) {
        
        Date date = new Date();
        
        model.setUpdatedTime(date);
        
        hibernateTemplate.update(model);
        
        return model;
    }

    /* (non-Javadoc)
     * @see dao.BaseDao#get(java.lang.Class, java.lang.String)
     */
    @Override
    public T get(Class<T> modelClass, String id) {
        
        return hibernateTemplate.load(modelClass, id);
    }

    /* (non-Javadoc)
     * @see dao.BaseDao#find(java.lang.String, java.lang.Object[])
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> find(String hql, Object... values) {
        
        return hibernateTemplate.find(hql, values);
    }

    /* (non-Javadoc)
     * @see dao.BaseDao#findAll(java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll(Class<T> modelClass) {
        
        String hql = "FROM " + modelClass.getName() + "WHREE isExpired = ?";
        
        return hibernateTemplate.find(hql, Boolean.FALSE);
    }

    /* (non-Javadoc)
     * @see dao.BaseDao#findByCriteria(org.hibernate.criterion.DetachedCriteria)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByCriteria(DetachedCriteria criteria) {
        
        return hibernateTemplate.findByCriteria(criteria);
    }

    /* (non-Javadoc)
     * @see dao.BaseDao#findByCriteria(org.hibernate.criterion.DetachedCriteria, VO.Page)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Page<T> findByCriteria(DetachedCriteria criteria, Page<T> page) {
        
        int firstResult = page.getStartRecord();
        int maxResult = page.getPageSize();
        List<T> list = null;
        
        if(0 == page.getRecordCount()){
            int recordCount = 0;
            
            //Get the count
            criteria.setProjection(Projections.rowCount());
            recordCount = Integer.parseInt(hibernateTemplate.findByCriteria(criteria).get(0)
                    .toString());
            criteria.setProjection(null);
            page.setRecordCount(recordCount);
        }
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
       
        //Get the result of query
        list = hibernateTemplate.findByCriteria(criteria, firstResult, maxResult);
        
        page.setResult(list);
        
        return page;
    }

    /* (non-Javadoc)
     * @see dao.BaseDao#findByHql(VO.Page, java.lang.String, java.lang.Object[])
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Page<T> findByHql(final Page<T> page, final String hql, final Object... values) {
        
        return (Page<T>) hibernateTemplate.execute(new HibernateCallback() {
            
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = createQuery(session, hql, values);
                query.setFirstResult(page.getStartRecord());
                query.setMaxResults(page.getPageSize());
                page.setResult(query.list());
                
                if(0 == page.getRecordCount()){
                    int recordCount = 0;
                    recordCount =  query.list().size();
                    page.setRecordCount(recordCount);
                }
                return page;
            }
        });
    }
    
    private Query createQuery(Session session, String queryString, Object... values){
        
        Query query = session.createQuery(queryString);
        
        if(null != values){
            for(int i = 0; i < values.length; i++){
                query.setParameter(i, values[i]);
            }
        }
        return query;
    }

    /* (non-Javadoc)
     * @see dao.BaseDao#getTotalCount(java.lang.Class)
     */
    @Override
    public int getTotalCount(Class<T> modelClass) {
        
        final String hql = "select count(*) from " + modelClass.getName() + "where isExpired = ?";
        @SuppressWarnings({ "unchecked", "rawtypes" })
        long count =(Long) hibernateTemplate.execute(new HibernateCallback(){
            public Object doInHibernate(Session session) throws HibernateException, SQLException{
                Query query =session.createQuery(hql);
                
                return query.uniqueResult();
            }
        });
        return (int) count;
    }

    /* (non-Javadoc)
     * @see dao.BaseDao#getCountByCriteria(org.hibernate.criterion.DetachedCriteria)
     */
    @Override
    public int getCountByCriteria(DetachedCriteria criteria) {
        
        int count =  0;
        
        criteria.setProjection(Projections.rowCount());
        count = Integer.parseInt(hibernateTemplate.findByCriteria(criteria).get(0).toString());
        
        return count;
    }

    /* (non-Javadoc)
     * @see dao.BaseDao#getCountByHql(java.lang.String, java.lang.Object[])
     */
    @Override
    public int getCountByHql(String hql, Object... values) {
        
        return Integer.parseInt(hibernateTemplate.find(hql, values).get(0).toString());
    }

    /* (non-Javadoc)
     * @see dao.BaseDao#getHibernateTemplate()
     */
    @Override
    public HibernateTemplate getHibernateTemplate() {
        
        return this.hibernateTemplate;
    }

    /* (non-Javadoc)
     * @see dao.BaseDao#saveOrUpdateAll(java.util.List)
     */
    @Override
    public List<T> saveOrUpdateAll(List<T> entities) {
        
        hibernateTemplate.saveOrUpdate(entities);
        
        return entities;
    }
    

}
