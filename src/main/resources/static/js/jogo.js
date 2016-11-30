var jogoModel = angular.module('jogoModel', []);

jogoModel.controller("jogoController", function ($scope, $http) {

    urlJogo = 'game';

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

    $scope.buscaMachineChoice();
});