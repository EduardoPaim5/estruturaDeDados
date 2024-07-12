package Trabalho4;

import java.util.*;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        // Criação das estruturas de dados
        MapCustom<Integer, Veiculo> orderedVectorMap = new MapaVetorOrdenado<Integer, Veiculo>();
        MapCustom<Integer, Veiculo> bstMap = new ABB<>();
        MapCustom<Integer, Veiculo> avlMap = new AVL<>();

        // Gerar 100.000 veículos
        List<Veiculo> veiculos = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            veiculos.add(new Veiculo());
        }

        // Inserir 100.000 veículos e medir o tempo
        long start = System.nanoTime();
        for (Veiculo veiculo : veiculos) {
            orderedVectorMap.put(veiculo.getChassi(), veiculo);
        }
        long end = System.nanoTime();
        System.out.println(STR."Tempo de inserção no Vetor Ordenado: \{end - start} ns");

        start = System.nanoTime();
        for (Veiculo veiculo : veiculos) {
            bstMap.put(veiculo.getChassi(), veiculo);
        }
        end = System.nanoTime();
        System.out.println(STR."Tempo de inserção na Map.ABB: \{end - start} ns");

        start = System.nanoTime();
        for (Veiculo veiculo : veiculos) {
            avlMap.put(veiculo.getChassi(), veiculo);
        }
        end = System.nanoTime();
        System.out.println(STR."Tempo de inserção na Map.AVL: \{end - start} ns");

        // Apresentar todos os veículos em ordem crescente de número de chassi
        start = System.nanoTime();
        Collection<Veiculo> vectorValues = orderedVectorMap.values();
        end = System.nanoTime();
        System.out.println(STR."Tempo para listar veículos no Vetor Ordenado: \{end - start} ns");

        start = System.nanoTime();
        Collection<Veiculo> bstValues = bstMap.values();
        end = System.nanoTime();
        System.out.println(STR."Tempo para listar veículos na Map.ABB: \{end - start} ns");

        start = System.nanoTime();
        Collection<Veiculo> avlValues = avlMap.values();
        end = System.nanoTime();
        System.out.println(STR."Tempo para listar veículos na Map.AVL: \{end - start} ns");

        // Verificar quantos veículos são da marca Ford
        start = System.nanoTime();
        long count = vectorValues.stream().filter(Veiculo::isMarcaFord).count();
        end = System.nanoTime();
        System.out.println(STR."Tempo para contar veículos Ford no Vetor Ordenado: \{end - start} ns");

        start = System.nanoTime();
        count = bstValues.stream().filter(Veiculo::isMarcaFord).count();
        end = System.nanoTime();
        System.out.println(STR."Tempo para contar veículos Ford na Map.ABB: \{end - start} ns");

        start = System.nanoTime();
        count = avlValues.stream().filter(Veiculo::isMarcaFord).count();
        end = System.nanoTime();
        System.out.println(STR."Tempo para contar veículos Ford na Map.AVL: \{end - start} ns");

        // Remover todos os veículos com número de chassi igual ou inferior à 202050000
        start = System.nanoTime();
        for (Veiculo veiculo : new ArrayList<>(vectorValues)) {
            if (veiculo.getChassi() <= 202050000) {
                orderedVectorMap.remove(veiculo.getChassi());
            }
        }
        end = System.nanoTime();
        System.out.println(STR."Tempo para remover veículos no Vetor Ordenado: \{end - start} ns");

        start = System.nanoTime();
        for (Veiculo veiculo : new ArrayList<>(bstValues)) {
            if (veiculo.getChassi() <= 202050000) {
                bstMap.remove(veiculo.getChassi());
            }
        }
        end = System.nanoTime();
        System.out.println(STR."Tempo para remover veículos na Map.ABB: \{end - start} ns");

        start = System.nanoTime();
        for (Veiculo veiculo : new ArrayList<>(avlValues)) {
            if (veiculo.getChassi() <= 202050000) {
                avlMap.remove(veiculo.getChassi());
            }
        }
        end = System.nanoTime();
        System.out.println(STR."Tempo para remover veículos na Map.AVL: \{end - start} ns");
    }
}
