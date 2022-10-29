package pl.mirekgab.exceptionexample.service;

import org.springframework.stereotype.Service;
import pl.mirekgab.exceptionexample.exception.ExceptionMessage;
import pl.mirekgab.exceptionexample.exception.AppRuntimeException;
import pl.mirekgab.exceptionexample.model.Wallet;

import java.util.Arrays;
import java.util.List;

@Service
public class WalletService {
    List<Wallet> list = Arrays.asList(
            new Wallet(1L, "wallet1"),
            new Wallet(2L, "wallet2"));

    public List<Wallet> getAllWallets() {
        return list;
    }

    public Wallet getWallet(Long id) {
        return list.stream().filter(w -> id.equals(w.getId())).findAny().orElseThrow(() ->
                new AppRuntimeException(
                        ExceptionMessage.CODE_NOT_FOUND, ExceptionMessage.STATUS_WALLET_NOT_FOUND));
    }

    /**
     * method throw exception
     */
    public Wallet createWallet(Wallet wallet) {
        throw new AppRuntimeException(
                ExceptionMessage.CODE_SERVER_ERROR, ExceptionMessage.STATUS_SERVER_ERROR);
    }

}
