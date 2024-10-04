package com.thaisrosa.economy.service;

import com.thaisrosa.economy.domain.TipoTransacaoEnum;
import com.thaisrosa.economy.domain.Transacao;
import com.thaisrosa.economy.domain.User;
import com.thaisrosa.economy.repository.TransacaoRepository;
import com.thaisrosa.economy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Transacao> getAllDespesa(String userToken) {
        User user = userRepository.findByToken(userToken);
        return transacaoRepository.findAllByTipoTransacaoAndUser(TipoTransacaoEnum.DESPESA, user);
    }

    public List<Transacao> getAllReceita(String userToken) {
        User user = userRepository.findByToken(userToken);
        return transacaoRepository.findAllByTipoTransacaoAndUser(TipoTransacaoEnum.RECEITA, user);
    }

    public Transacao createDespesa(Transacao transacao, String userToken) {
        User user = userRepository.findByToken(userToken);

        transacao.setUser(user);
        transacao.setTipoTransacao(TipoTransacaoEnum.DESPESA);
        return transacaoRepository.save(transacao);
    }

    public Transacao createReceita(Transacao transacao, String userToken) {
        User user = userRepository.findByToken(userToken);

        transacao.setUser(user);
        transacao.setTipoTransacao(TipoTransacaoEnum.RECEITA);
        return transacaoRepository.save(transacao);
    }

    public void delete(Long id) {
        transacaoRepository.deleteById(id);
    }
}