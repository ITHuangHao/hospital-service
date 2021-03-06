package cn.yujian95.hospital.service;

import cn.yujian95.hospital.dto.param.HospitalDoctorParam;
import cn.yujian95.hospital.entity.HospitalDoctor;

import java.util.List;
import java.util.Optional;

/**
 * @author YuJian95  clj9509@163.com
 * @date 2020/2/4
 */

public interface IHospitalDoctorService {

    /**
     * 添加医生信息
     *
     * @param param 医生信息参数
     * @return 是否成功
     */
    boolean insert(HospitalDoctorParam param);

    /**
     * 更新医生信息
     *
     * @param id    医生编号
     * @param param 医生信息参数
     * @return 是否成功
     */
    boolean update(Long id, HospitalDoctorParam param);

    /**
     * 是否存在医生信息
     *
     * @param id 医生编号
     * @return 是否存在
     */
    boolean count(Long id);

    /**
     * 获取医生信息
     *
     * @param id 医生编号
     * @return 医生编号
     */
    Optional<HospitalDoctor> getOptional(Long id);

    /**
     * 删除医生信息
     *
     * @param id 医生编号
     * @return 是否成功
     */
    boolean delete(Long id);

    /**
     * 查找医生信息
     *
     * @param name     医生名称
     * @param pageNum  第几页
     * @param pageSize 页大小
     * @return 医生信息列表
     */
    List<HospitalDoctor> list(String name, Integer pageNum, Integer pageSize);
}
