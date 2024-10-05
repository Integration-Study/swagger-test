package demo.swaggertest.v2.dto;

import java.util.List;

public record ListWrapper <T>(
        List<T> result
){
}
