package com.it.wcj.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {
    /**
     * 主键id
     **/
    private Long deptno;
    /**
     * 部门名称
     **/
    private String dname;
    /**
     * 来自哪个数据库
     **/
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
