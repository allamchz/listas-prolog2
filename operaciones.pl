
insertar(X, [], [X]).
insertar(X, [Y | Resto], [X, Y | Resto]) :- X =< Y.
insertar(X, [Y | Resto], [Y | ListaConX]) :-
    X > Y,
    insertar(X, Resto, ListaConX).

% ordenada(ListaDesordenada, ListaOrdenada) es verdadero si ListaOrdenada es la lista ordenada de ListaDesordenada usando inserción.
ordenada([], []).
ordenada([X | Resto], ListaOrdenada) :-
    ordenada(Resto, ListaParcialmenteOrdenada),
    insertar(X, ListaParcialmenteOrdenada, ListaOrdenada).

hombre(juan,grande,rubio,joven).
hombre(antonio,mediana,castano,maduro).
hombre(pepe,mediana,moreno,anciano).
hombre(luis,mediana,moreno,joven).
mujer(maria,pequena,moreno,joven).
mujer(sara,grande,moreno,joven).
mujer(laura,mediana,pelirrojo,maduro).
mujer(eva,mediana,rubio,anciano).
gustos(juan,clasica,aventuras,tenis).
gustos(antonio,pop,ciencia-ficcion,natacion).
gustos(pepe,jazz,detectives,yoga).
gustos(luis,jazz,ciencia-ficcion,natacion).
gustos(maria,jazz,ciencia-ficcion,natacion).
gustos(sara,pop,aventuras,tenis).
gustos(laura,clasica,detectives,yoga).
gustos(eva,jazz,detectives,natacion).
busca(juan,mediana,rubio,joven).
busca(antonio,pequena,pelirrojo,joven).
busca(pepe,mediana,moreno,maduro).
busca(luis,pequena,moreno,joven).
busca(maria,mediana,moreno,joven).
busca(sara,grande,castano,maduro).
busca(laura,grande,moreno,maduro).
busca(eva,mediana,rubio,anciano).
compatible(X,Y) :- gustos(X,A,B,C),
gustos(Y,A,B,C), busca(X,O,P,Q),
 mujer(Y,O,P,Q), X\=Y, compatible(Y,X).

compatible(X,Y) :- gustos(X,A,B,C), gustos(Y,A,B,C),
busca(X,O,P,Q), hombre(Y,O,P,Q), X\=Y.