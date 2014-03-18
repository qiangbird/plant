package service.impl;

import java.util.HashSet;
import java.util.Set;

import model.Company;
import model.Contact;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import service.CompanyService;
import VO.CompanyVo;
import dao.CompanyDao;

@Repository("companyService")
public class CompanyServiceImpl implements CompanyService{

    private Logger logger = Logger.getLogger(CompanyServiceImpl.class);
    
    @Autowired
    private CompanyDao companyDao;
    
    /* (non-Javadoc)
     * @see service.CompanyService#saveCompany(VO.CompanyVo)
     */
    @Override
    public void saveCompany(CompanyVo companyVo) {
        
        logger.info("start...");
                
        Company company = new Company();
        
        company.setName(companyVo.getName());
        company.setDescription(companyVo.getDescription());
        company.setAddress(companyVo.getAddress());
        company.setContacts(getContacts(companyVo));
        
        companyDao.save(company);
        
        logger.info("end...");
    }

    /* (non-Javadoc)
     * @see service.CompanyService#getCompany(VO.CompanyVo)
     */
    @Override
    public JSONObject getCompany(CompanyVo companyVo) {
        
        logger.info("start...");
        
        Company company = companyDao.get(Company.class, companyVo.getId());
        
        JSONObject object = new JSONObject();
        
        object.put("companyId", company.getId());
        object.put("companyName", company.getName());
        object.put("description", company.getDescription());
        object.put("address", company.getAddress());
        object.put("contact", company.getContacts().toArray());
        
        logger.info("end...");
        return object;
    }

    /* (non-Javadoc)
     * @see service.CompanyService#updateCompany(VO.CompanyVo)
     */
    @Override
    public void updateCompany(CompanyVo companyVo) {
        
        logger.info("start...");
        
        Company company = companyDao.get(Company.class, companyVo.getId());
        
        company.setName(companyVo.getName());
        company.setDescription(companyVo.getDescription());
        company.setAddress(companyVo.getAddress());
        company.setContacts(getContacts(companyVo));
        
        companyDao.update(company);
        
        logger.info("end...");
    }

    /* (non-Javadoc)
     * @see service.CompanyService#deleteCompany(VO.CompanyVo)
     */
    @Override
    public void deleteCompany(CompanyVo companyVo) {
        
        logger.info("start...");
        
        Company company = companyDao.get(Company.class, companyVo.getId());
        companyDao.delete(company);
        
        logger.info("end...");
    }
    
    private Set<Contact> getContacts(CompanyVo companyVo){
    
        logger.info("start...");
        
        Set<Contact> contacts = new HashSet<Contact>();
        //get contacts
        for(int i = 0; i < companyVo.getAddress().length(); i++){
           Contact contact = new Contact();
           
           contact.setTelephone(companyVo.getTelephones()[i]);
           contact.setName(companyVo.getContacts()[i]);
           
           contacts.add(contact);
        }
        
        logger.info("end...");
        return contacts;
    }

}
