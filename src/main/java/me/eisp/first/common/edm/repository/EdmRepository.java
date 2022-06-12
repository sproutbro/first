package me.eisp.first.common.edm.repository;

import me.eisp.first.common.edm.dto.Edm1Info;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EdmRepository {

    Edm1Info getEdm1Info(String empId);

}
