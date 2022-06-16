package me.eisp.first.common.edm;

import lombok.AllArgsConstructor;
import me.eisp.first.common.edm.dto.Edm1;
import me.eisp.first.common.edm.service.EdmService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class api {

    EdmService edmService;

    @PostMapping("/edm1Test")
    public String sendEdm1(@Param("edm1") Edm1 edm1) {
        return edmService.sendEdm1(edm1);
    }

}
