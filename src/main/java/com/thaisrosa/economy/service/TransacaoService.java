package com.thaisrosa.economy.service;

import com.thaisrosa.economy.domain.TipoTransacaoEnum;
import com.thaisrosa.economy.domain.Transacao;
import com.thaisrosa.economy.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Transacao> getAllDespesa() {
        return transacaoRepository.findAllByTipoTransacao(TipoTransacaoEnum.DESPESA);
    }

    public List<Transacao> getAllReceita() {
        return transacaoRepository.findAllByTipoTransacao(TipoTransacaoEnum.RECEITA);
    }

    public Transacao createDespesa(Transacao transacao) {
        transacao.setTipoTransacao(TipoTransacaoEnum.DESPESA);
        return transacaoRepository.save(transacao);
    }

    public Transacao createReceita(Transacao transacao) {
        transacao.setTipoTransacao(TipoTransacaoEnum.RECEITA);
        return transacaoRepository.save(transacao);
    }

    public void delete(Long id) {
        transacaoRepository.deleteById(id);
    }
}