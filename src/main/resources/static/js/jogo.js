var jogoModel = angular.module('jogoModel', []);

jogoModel.controller("jogoController", function ($scope, $http) {

    urlJogo = 'game';
    $scope.empates = 0;
    $scope.derrotas = 0;
    $scope.vitorias = 0;

    $scope.buscaMachineChoice = function() {
        $http.get(urlJogo + '/machinechoice').success(function(data) {
            $scope.machinechoice = data;
        }).error(function(erro) {
            $scope.message = erro;
            $('#myModal').modal('show');
        });
    }

	$scope.showImgMachine = false;

	$scope.sendChoice = function(choiceUser) {

        $scope.showImgMachine = true;

        var game = {
            idMoveUser: choiceUser,
            idMoveMachine: $scope.machinechoice.choice
        };

        $http.post(urlJogo, game).success(function (data) {
            if (data.valor === 0) {
                $scope.empates += 1;
            } else if (data.valor === 1) {
                $scope.vitorias += 1;
            } else {
                $scope.derrotas += 1;
            }

            $scope.message = data.result;
            $('#myModal').modal('show');
        }).error(function (erro) {
            $scope.errorMessage = erro;
            $('#myModal').modal('show');
        })
	}

    $scope.reload = function() {
        $scope.showImgMachine = false;
        $scope.buscaMachineChoice();
    }

    $scope.getPercentage = function(re) {
        total = $scope.derrotas + $scope.empates + $scope.vitorias;

        if (total === 0) return 33.33;

        var number = re === -1 ? $scope.derrotas / total : re === 0 ? $scope.empates / total: $scope.vitorias / total;
        return number * 100 ;

    }

    $scope.buscaMachineChoice();
});