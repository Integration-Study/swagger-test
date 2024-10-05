package demo.swaggertest.v1.dto;

import java.util.List;

public record ListWrapper <T>(
        List<T> result
){
}
