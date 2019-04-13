package com.mevo.statistics.mevo.data.token;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class TokenGetServiceTest {

    @InjectMocks
    private TokenGetService tokenGetService;
    
    @Test
    void shouldReturnToken() throws Exception {
        //arrange && act
        var result = tokenGetService.getToken();

        //assert
        assertThat(result).isNotNull();
        assertThat(result.length()).isEqualTo(40);
    }
}