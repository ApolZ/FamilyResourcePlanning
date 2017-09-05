package frp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ZhuHanxi
 * @Date 03/09/2017
 */
@Entity
@Table(name = "t_coupon")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String description;

    private Integer type;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "used_date")
    private Date usedDate;

    private Integer state;

    @Column(name = "owner_id")
    private Integer ownerId;
}
