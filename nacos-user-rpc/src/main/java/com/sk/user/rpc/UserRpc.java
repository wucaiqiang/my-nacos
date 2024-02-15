package com.sk.user.rpc;

import com.sk.user.api.UserInterface;
import com.sk.user.api.dto.PageQueryDTO;
import com.sk.user.api.dto.ResponseData;
import com.sk.user.api.dto.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author shirken
 * @describe
 * @date 2024/2/2 4:31 PM
 */
@FeignClient(name = UserInterface.SERVICE_NAME, fallback = UserRpc.HystrixClientFallback.class)
public interface UserRpc extends UserInterface {
    @Component
    public static class HystrixClientFallback implements UserInterface {

        @Override
        public String get(Integer id) {
            return null;
        }

        @Override
        public ResponseData<Object> getList(UserDO bo) {
            return null;
        }

        @Override
        public String getByName(String name) {
            return null;
        }

        @Override
        public ResponseData<Object> getPage(PageQueryDTO pageQueryDTO) {
            return null;
        }
    }

}
