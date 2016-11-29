var jogoModel = angular.module('jogoModel', []);

jogoModel.controller("jogoController", function ($scope, $http) {

    urlJogo = 'game';

    $scope.buscaMachineChoice = function() {
        $http.get(urlJogo + '/machinechoice').success(function(data) {
            $scope.machinechoice = data;
        }).error(function(erro) {
            $('#myModal').modal('show');
        });
    }

	$scope.showImgMachine = false;
	$scope.machinechoice = {choice:1};

	$scope.sendChoice = function(choiceUser) {
		$scope.showImgMachine = true;
        $scope.machinechoice = {choice:1};
		$('#myModal').modal('show');
	}

    $scope.reload = function() {
        $scope.showImgMachine = false;
        $scope.machinechoice = {choice:0};
    }

	$scope.result = {
		winner: 0,
		message: "Empate, que triste!"
	}
});