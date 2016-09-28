package com.dalgen.mybatis.model.repository;

import com.dalgen.mybatis.enums.MultiplicityEnum;
import com.dalgen.mybatis.model.config.CfOperation;

import junit.framework.TestCase;

public class CfTableRepositoryTest extends TestCase {
	public void testSetCfOperationPageCdata() {
		String cdata = "select u.admin_id ,u.name ,u.lock_status ,u.user_status ,u.sms_auth_enable ,u.real_name ,GROUP_CONCAT(role.role_name) role_name from LJ_ADMIN_USER AS u LEFT JOIN yii2rbac_admin_user_role AS userRole ON userRole.admin_id = u.admin_id LEFT JOIN yii2rbac_role AS role ON role.role_id = userRole.role_id where 1=1 <if test=\"adminId!=null\"> AND u.admin_id = #{adminId,jdbcType=INTEGER} </if> <if test=\"name!=null\"> AND u.name like concat('%',#{name},'%') </if> <if test=\"lockStatus!=null\"> AND u.lock_status = #{lockStatus,jdbcType=INTEGER} </if> <if test=\"userStatus!=null\"> AND u.user_status = #{userStatus,jdbcType=INTEGER} </if> <if test=\"smsAuthEnable!=null\"> AND u.sms_auth_enable = #{smsAuthEnable,jdbcType=INTEGER} </if> <if test=\"roleId!=null\"> AND userRole.role_id = #{roleId,jdbcType=INTEGER} </if> group by u.admin_id <if>having 1=1</if> order by admin_id desc";
		CfOperation cfOperation = new CfOperation();
		cfOperation.setMultiplicity(MultiplicityEnum.paging);
		CfTableRepository service = new CfTableRepository();
		service.setCfOperationPageCdata(cdata, cfOperation);
		System.out.println(cfOperation.getCdataPageCount());
	}
}
