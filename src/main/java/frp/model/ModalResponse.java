package frp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 模态框返回值
 * @author ZhuHanxi
 * @Date 05/09/2017
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModalResponse {
    private String title;
    private String body;
    private int status;
}
