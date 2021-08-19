package top.coala.coalax.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * author: by@liuchengming
 * date: 2021/08/16/ 11:31
 * info:
 */
@Data
@AllArgsConstructor
public class Order {

    private String address;
    private String name;
    private String mobile;
    private Integer count;

}
