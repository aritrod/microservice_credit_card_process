package com.sapient.credit.card.sb.process.springboot;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sapient.credit.card.sb.process.dao.CreditCardProcessDAO;
import com.sapient.credit.card.sb.process.model.CreditCard;
import com.sapient.credit.card.sb.process.rest.CreditCardProcessService;

/**
 * Unit test for CreditCardProcessService.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = CreditCardProcessService.class, secure = false)
public class CreditCardProcessServiceTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CreditCardProcessDAO creditCardProcessDAO;
	
	
	CreditCard mockCardOne = new CreditCard(1L,"AAA","12345","1000","10000");
	CreditCard mockCardTwo = new CreditCard(2L,"BBB","67890","2000","20000");
	List<CreditCard> mockCards = Arrays.asList(mockCardOne,mockCardTwo);
	
	@Test
	public void getCreditCards() throws Exception {
		Mockito.when(creditCardProcessDAO.listCreditCards()).thenReturn(mockCards);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/sapient/creditCard/list").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result);
		
	}
    
}
