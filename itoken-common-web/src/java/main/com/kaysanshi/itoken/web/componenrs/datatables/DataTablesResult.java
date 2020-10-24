package com.kaysanshi.itoken.web.componenrs.datatables;

import com.kaysanshi.itoken.common.dto.BaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 这里中是对其扩展，可以直接用到这个DataTablesResult类
 * @Author kay三石
 * @date:2019/8/24
 * DataTables中需要的参数，除了有data外还需要以下的参数
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DataTablesResult extends BaseResult implements Serializable {

    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private String error;
}
