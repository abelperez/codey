<?php

/**
 * remove the following line in production
 */
define('__DEBUG__', 'debug');

require_once("${SIMPLECLASSNAME}.config.php");

class ${CLASSNAME}Controller extends Controller
{
	/*
	 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  Controller Actions
	 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	*/
		
	public function view() {
		require('view-${SIMPLECLASSNAME}-form.html');
	}
	
	public function save() {
		try {
			$entity = new ${CLASSNAME}();
			$entity = $this->bind($entity);
			$entity->saveOrUpdate();
			echo '{"status":"success","message":"${SIMPLECLASSNAME} has been saved: '.$entity->id.'"}';
			
		} catch (Exception $exception) {
			echo '{"status":"failed","message":"failed to save ${SIMPLECLASSNAME}"}';
		}
	}
	
	public function viewlist() {
		$entity = new ${CLASSNAME}();
		$entities = $entity->findAll();
		require('view-${SIMPLECLASSNAME}-list.html');
	}
}

$controller = new ${CLASSNAME}Controller();
$controller->route();

?>