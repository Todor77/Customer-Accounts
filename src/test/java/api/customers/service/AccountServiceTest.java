package api.customers.service;

import api.customers.entity.Account;
import api.customers.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void testOpenAccount() {
        int customerId = 1;

        Account expectedAccount = new Account(customerId);

        when(accountRepository.createAccount(customerId)).thenReturn(expectedAccount);

        Account actualAccount = accountService.createAccount(customerId);
        assertEquals(expectedAccount.getAccountNumber(), actualAccount.getAccountNumber(), 0);
    }


}
