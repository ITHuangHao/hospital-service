package cn.yujian95.hospital.service.impl;

import cn.yujian95.hospital.dto.param.UserCaseParam;
import cn.yujian95.hospital.dto.param.UserCaseUpdateParam;
import cn.yujian95.hospital.entity.UserCase;
import cn.yujian95.hospital.entity.UserCaseExample;
import cn.yujian95.hospital.mapper.UserCaseMapper;
import cn.yujian95.hospital.service.IUserCaseService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author YuJian95  clj9509@163.com
 * @date 2020/3/2
 */

@Service
public class UserCaseServiceImpl implements IUserCaseService {

    @Resource
    private UserCaseMapper caseMapper;

    /**
     * 创建病例信息
     *
     * @param param 病例参数
     * @return 是否成功
     */
    @Override
    public boolean insert(UserCaseParam param) {
        UserCase userCase = new UserCase();

        BeanUtils.copyProperties(param, userCase);

        userCase.setGmtCreate(new Date());
        userCase.setGmtModified(new Date());

        return caseMapper.insertSelective(userCase) > 0;
    }

    /**
     * 更新病例信息
     *
     * @param id    病例参数
     * @param param 病例参数
     * @return 是否成功
     */
    @Override
    public boolean update(Long id, UserCaseUpdateParam param) {
        UserCase userCase = new UserCase();

        BeanUtils.copyProperties(param, userCase);

        userCase.setId(id);
        userCase.setGmtModified(new Date());

        return caseMapper.updateByPrimaryKeySelective(userCase) > 0;
    }

    /**
     * 删除病例信息
     *
     * @param id 记录编号
     * @return 是否成功
     */
    @Override
    public boolean delete(Long id) {
        return caseMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 判断病例信息，是否存在
     *
     * @param id 记录编号
     * @return 是否存在
     */
    @Override
    public boolean count(Long id) {

        UserCaseExample example = new UserCaseExample();

        example.createCriteria()
                .andIdEqualTo(id);

        return caseMapper.countByExample(example) > 0;
    }

    /**
     * 获取病例信息
     *
     * @param accountId 账号编号
     * @param orderId   预约记录
     * @return 是否存在
     */
    @Override
    public Optional<UserCase> getOptional(Long accountId, Long orderId) {
        UserCaseExample example = new UserCaseExample();

        example.createCriteria()
                .andAccountIdEqualTo(accountId)
                .andOrderIdEqualTo(orderId);


        return Optional.ofNullable(caseMapper.selectByExample(example).get(0));
    }

    /**
     * 获取病例列表
     *
     * @param accountId 账号编号
     * @param pageNum   第几页
     * @param pageSize  页大小
     * @return 病例列表
     */
    @Override
    public List<UserCase> list(Long accountId, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        UserCaseExample example = new UserCaseExample();

        example.createCriteria()
                .andAccountIdEqualTo(accountId);


        return caseMapper.selectByExample(example);
    }
}
