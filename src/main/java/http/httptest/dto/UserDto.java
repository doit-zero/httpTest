package http.httptest.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

// 테스트를 하기 위해 @Data를 씀
@Data
public class UserDto {
    private String name;
    private MultipartFile file;
}
