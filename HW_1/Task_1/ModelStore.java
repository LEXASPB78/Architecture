package HW_1;

import java.util.ArrayList;

public class ModelStore implements ModelChangeObserver, ModelChanger {

  ArrayList<PoligonalModel> Models = new ArrayList<>();
  ArrayList<Scene> Scenes = new ArrayList<>();
  ArrayList<Flash> Flashes = new ArrayList<>();
  ArrayList<Camera> Cameras = new ArrayList<>();

  public Scene getScene(int n_scene) {

    return Scenes.get(n_scene);
  }

  @Override
  public void NotifyChange() {
    // TODO Auto-generated method stub

  }

  @Override
  public void ApplyUpdateModel() {
    // TODO Auto-generated method stub

  }
}
