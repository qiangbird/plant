package service;

import net.sf.json.JSONObject;
import VO.CompanyVo;

public interface CompanyService {

    /**
     * Save the Company model
     * @param companyVo
     */
    void saveCompany(CompanyVo companyVo);

    /**
     * Get a Company entity by id
     * @param companyVo
     * @return
     */
    JSONObject getCompany(CompanyVo companyVo);

    /**
     * Update the company entity
     * @param companyVo
     */
    void updateCompany(CompanyVo companyVo);

    /**
     * Delete the company entity by id
     * @param companyVo
     */
    void deleteCompany(CompanyVo companyVo);

}
