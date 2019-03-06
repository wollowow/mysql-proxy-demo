package com.angla.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 实体</p>
 * masterSlave对应数据库表 t_master_slave
 * @author liumenghua
 * @project hshcics
 * @date  2019-1-24 14:47:55
 */
@Data
@NoArgsConstructor
@Alias("masterSlave")
public class MasterSlaveModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//主键字段
	private Long id;
	
	private String name;
	

	@Override
	public String toString() {
		return "MasterSlaveModel [id=" + id + ",name=" + name + "]";
	}
}