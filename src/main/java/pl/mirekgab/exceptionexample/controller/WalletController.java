package pl.mirekgab.exceptionexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mirekgab.exceptionexample.model.Wallet;
import pl.mirekgab.exceptionexample.service.WalletService;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    WalletService walletService;

    @GetMapping
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

    /**
     * this endpoint throws exception
     */
    @PostMapping
    public Wallet createWallet(Wallet wallet) {
        return walletService.createWallet(wallet);
    }

    @GetMapping("/{id}")
    public Wallet getWallet(@PathVariable Long id) {
        return walletService.getWallet(id);
    }
}
