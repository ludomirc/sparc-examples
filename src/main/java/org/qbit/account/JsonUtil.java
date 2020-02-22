package org.qbit.account;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.ResponseTransformer;

public class JsonUtil {
    public static String toJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new AccountException(e);
        }
    }

    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }
}