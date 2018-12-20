package com.aibyd.apps.db.dao;

import com.aibyd.apps.db.domain.AppsUser;
import com.aibyd.apps.db.domain.AppsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppsUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     */
    long countByExample(AppsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     */
    int deleteByExample(AppsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     */
    int insert(AppsUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     */
    int insertSelective(AppsUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    AppsUser selectOneByExample(AppsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    AppsUser selectOneByExampleSelective(@Param("example") AppsUserExample example, @Param("selective") AppsUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<AppsUser> selectByExampleSelective(@Param("example") AppsUserExample example, @Param("selective") AppsUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     */
    List<AppsUser> selectByExample(AppsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    AppsUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") AppsUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     */
    AppsUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") AppsUser record, @Param("example") AppsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") AppsUser record, @Param("example") AppsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AppsUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apps_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AppsUser record);
}