package com.aibyd.apps.db.dao;

import com.aibyd.apps.db.domain.MallTopic;
import com.aibyd.apps.db.domain.MallTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallTopicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     */
    long countByExample(MallTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     */
    int deleteByExample(MallTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     */
    int insert(MallTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     */
    int insertSelective(MallTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    MallTopic selectOneByExample(MallTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    MallTopic selectOneByExampleSelective(@Param("example") MallTopicExample example, @Param("selective") MallTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    MallTopic selectOneByExampleWithBLOBs(MallTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<MallTopic> selectByExampleSelective(@Param("example") MallTopicExample example, @Param("selective") MallTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     */
    List<MallTopic> selectByExampleWithBLOBs(MallTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     */
    List<MallTopic> selectByExample(MallTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    MallTopic selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MallTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     */
    MallTopic selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    MallTopic selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MallTopic record, @Param("example") MallTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") MallTopic record, @Param("example") MallTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MallTopic record, @Param("example") MallTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MallTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(MallTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MallTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") MallTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer id);
}